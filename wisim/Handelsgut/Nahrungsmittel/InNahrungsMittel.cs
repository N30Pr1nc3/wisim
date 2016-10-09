using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace wisim.Handelsgut.Nahrungsmittel
{
    interface InNahrungsMittel:InHandelsgut
    {
        int NaehrGehalt { get; }
    }
}
