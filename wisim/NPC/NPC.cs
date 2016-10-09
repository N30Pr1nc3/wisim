
using System;
using System.Collections.Generic;
using wisim.Bedarf;
using wisim.Handelsgut;
using wisim.Handelsgut.Nahrungsmittel;

namespace wisim.NPC
{
    public class Npc
    {
        private int geld = 1000;

        private List<InBedarf> _beduerfnisse = new List<InBedarf>();
        private List<InHandelsgut> _besitz = new List<InHandelsgut>();

        public List<InHandelsgut> Besizt { get { return this._besitz; } }

        public void bedarfBefriedigen()
        {
            //versuchen die bedürfnisse der Reihe Nach zu befriedigen 
            foreach(InBedarf bedarf in this._beduerfnisse)
            {
                //wenn der bedarf nicht gestillt werden konnte
                if (!bedarf.Stillen())
                {

                }
            }
        }

        internal void handelsgutVerbrauchen(InHandelsgut _handelsGut)
        {
            if (this._besitz.Contains(_handelsGut))
            {
                this._besitz.Remove(_handelsGut);
            }
        }
    }
}
