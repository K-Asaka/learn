using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var bmicalc = new BmiCalculator();
            int h = 162;
            int w = 63;
            var bmi = bmicalc.GetBmi(h, w);
            Console.WriteLine("{0:.00}", bmi);
        }
    }

    class BmiCalculator
    {
        // 身長はcm単位で、体重はkg単位で渡してもらう
        public double GetBmi(double height, double weight)
        {
            var metersTall = height / 100.0;
            var bmi = weight / (metersTall * metersTall);
            return bmi;
        }
    }
}
