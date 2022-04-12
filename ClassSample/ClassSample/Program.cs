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
            var mapLocation = new MyApp.Map.Location();
            var canvasLocation = new MyApp.Drawing.Location();
        }
    }
}

namespace MyApp.Map
{
    class Location
    {
        public double Latitude { get; set; }    // 緯度
        public double Longitude { get; set; }   // 経度
    }
}

namespace MyApp.Drawing
{
    class Location
    {
        public int X { get; set; }  // X座標
        public int Y { get; set; }  // Y座標
    }
}
