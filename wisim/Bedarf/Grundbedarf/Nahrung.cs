using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using wisim.Handelsgut.Nahrungsmittel;

namespace wisim.Bedarf.Grundbedarf
{
    class Nahrung : AbsBedarf<InNahrungsMittel>
    {
        private static Type[] _bedarfsType = new Type[1] { typeof(InNahrungsMittel) };
        public override int BedarfProUpgrade { get { return 30; } }
        public override int StundenProUpgrade { get { return 3; } }

        public override Type[] BedarfsTyp { get { return Nahrung._bedarfsType; } }     

        protected override bool subStillen(InNahrungsMittel _bedarfTyp)
        {
            int naergehalt = _bedarfTyp.NaehrGehalt;
            if (this._bedarf > naergehalt)
            {
                this._bedarf = this._bedarf - naergehalt;
                this._npc.handelsgutVerbrauchen(_bedarfTyp);
            }
            else
            {
                return true;
            }
            if (this._bedarf < 100)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
