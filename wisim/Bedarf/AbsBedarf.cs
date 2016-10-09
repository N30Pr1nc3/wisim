using System;
using wisim.Handelsgut;
using wisim.NPC;

namespace wisim.Bedarf
{
    interface InBedarf
    {
        bool Stillen();
    }

    interface InGrundBeduerfniss
    {

    }

    public abstract class AbsBedarf<BedarfsStillTyp> : InBedarf
    {
        protected abstract bool subStillen(BedarfsStillTyp _bedarfTyp);

        private DateTime _LetztesBedarfsUpgrade = DateTime.Now;
        protected Npc _npc;
        protected int _bedarf = 0;
        public abstract Type[] BedarfsTyp { get; }
        public abstract int StundenProUpgrade { get; }        
        public abstract int BedarfProUpgrade { get; }

        public void Upgrade()
        {
            if ((DateTime.Now - this._LetztesBedarfsUpgrade).Hours > this.StundenProUpgrade)
            {
                this._bedarf += this.BedarfProUpgrade;
            }
        }

        public bool Stillen()
        {
            Type[] types = this.BedarfsTyp;

            foreach (InHandelsgut handelsgut in this._npc.Besizt)
            {
                foreach (Type type in types)
                {
                    if (handelsgut.GetType() != type)
                    {
                        continue;
                    }
                    if(!(handelsgut is BedarfsStillTyp))
                    {
                        continue;
                    }
                    if (this.subStillen((BedarfsStillTyp)handelsgut))
                    {
                        return true;
                    }
                }
            }
            return false;
        }        
    }
}

