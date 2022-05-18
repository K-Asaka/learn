﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringSample
{
    internal class Program
    {
        static void Main(string[] args)
        {
            StringCharsExample();
            StringLengthExample();
            StringIndexOfExample();
            StringInsertExample();
            StringSubstringExample();
        }

        static void StringCharsExample()
        {
            string str = "ABC";
            char c = str[1];        // c = 'B'
            Console.WriteLine(c);
        }

        static void StringLengthExample()
        {
            string str = "ABC", str2 = "あいうえお";
            int length1 = str.Length;       // length1 = 3
            int length2 = str2.Length;      // length2 = 5(全角文字も1字と数える)
            Console.WriteLine("length1 = " + length1);
            Console.WriteLine("length2 = " + length2);
        }

        static void StringIndexOfExample()
        {
            string str = "ABC", str2 = "1234567";
            int index1 = str.IndexOf('B');          // index1 = 1
            int index2 = str2.IndexOf("345");       // index2 = 2
            Console.WriteLine("index1 = " + index1);
            Console.WriteLine("index2 = " + index2);
        }

        static void StringInsertExample()
        {
            string str = "ABC";
            string str2 = str.Insert(2, "123");     // str2 = "AB123C";
            Console.WriteLine("str2 = " + str2);
        }

        static void StringSubstringExample()
        {
            string str = "1234567";
            string str2 = str.Substring(3);     // str2 = "4567"
            string str3 = str.Substring(2, 3);  // str3 = "345"
            Console.WriteLine("str2 = " + str2);
            Console.WriteLine("str3 = " + str3);
        }
    }
}
