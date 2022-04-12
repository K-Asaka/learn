using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ClassSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var lines = new string[]
            {
                "祇園精舎の鐘の声、諸行無常の響きあり。",
                "沙羅双樹の花の色、盛者必衰の理をあらはす。",
                "奢れる人も久しからず、ただ春の夜の夢のごとし。",
                "猛き者もつひにはほろびぬ、ひとへに風の前の塵に同じ。"
            };
            File.WriteAllLines("C:\\temp\\祇園精舎.txt", lines);
        }
    }
}