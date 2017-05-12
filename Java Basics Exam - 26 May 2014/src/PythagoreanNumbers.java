using System;
        using System.Threading;
        using System.Globalization;
        using System.Numerics;
        using System.Collections.Generic;
        using System.Text;
        using System.Linq;

class Uprajnenia_2
{
    static void Main()
    {
        Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;

        //Problem 8 - Lego blocks
        //int n = int.Parse(Console.ReadLine());
        //string[][] firstJag = new string[n][];
        //string[][] secondJag = new string[n][];
        //int sumFirstJag = 0;
        //int sumSecondJag = 0;

        //for (int i = 0; i < n; i++)
        //{
        //    string first = Console.ReadLine();
        //    firstJag[i] = first.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        //    sumFirstJag += firstJag[i].Length;
        //}
        //for (int i = 0; i < n; i++)
        //{
        //    string second = Console.ReadLine();
        //    char[] array = second.ToCharArray();
        //    Array.Reverse(array);
        //    second = string.Empty;
        //    foreach (var item in array)
        //    {
        //        second += item.ToString();
        //    }
        //    secondJag[i] = second.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);
        //    sumSecondJag += secondJag[i].Length;
        //}
        //int sum = firstJag[0].Length + secondJag[0].Length;
        //bool isEquals = true;
        //for (int i = 0; i < n; i++)
        //{
        //    if (firstJag[i].Length + secondJag[i].Length == sum)
        //    {
        //        isEquals = true;
        //    }
        //    else
        //    {
        //        isEquals = false;
        //    }

        //}
        //if (isEquals)
        //{
        //    for (int i = 0; i < n; i++)
        //    {
        //        Console.Write("[");
        //        var result = firstJag[i].Concat(secondJag[i]).ToArray();
        //        for (int j = 0; j < result.Length; j++)
        //        {
        //            if (j + 1 != result.Length)
        //            {
        //                Console.Write("{0}, ", result[j]);
        //            }
        //            else
        //            {
        //                Console.Write("{0}", result[j]);

        //            }
        //        }
        //        Console.Write("]");
        //        Console.WriteLine();

        //    }
        //}
        //else
        //{
        //    Console.WriteLine("The total number of cells is: {0}", sumFirstJag+sumSecondJag);
        //}


        // Problem 9
        //int n = int.Parse(Console.ReadLine());
        //string[] numbers = Console.ReadLine().Split(' ');
        //bool isResult = false;
        //for (int i = 0; i < n; i++)
        //{
        //    for (int i1 = 0; i1 < n ; i1++)
        //    {
        //        for (int i2 = 0; i2 < n; i2++)
        //        {
        //            for (int i3 = 0; i3 < n; i3++)
        //            {
        //                if (i < i1 && i2 < i3 && i1 != i2 && i1 != i3 && i != i2 && i != i3)
        //                {
        //                    if (numbers[i] + numbers[i1] == numbers[i2] + numbers[i3])
        //                    {
        //                        Console.WriteLine("{0}|{1}=={2}|{3}", numbers[i], numbers[i1], numbers[i2], numbers[i3]);
        //                        isResult = true;
        //                    }
        //                    else if (numbers[i1] + numbers[i] == numbers[i2] + numbers[i3])
        //                    {
        //                        Console.WriteLine("{0}|{1}=={2}|{3}", numbers[i1], numbers[i], numbers[i2], numbers[i3]);
        //                        isResult = true;

        //                    }
        //                    else if (numbers[i1] + numbers[i] == numbers[i3] + numbers[i2])
        //                    {
        //                        Console.WriteLine("{0}|{1}=={2}|{3}", numbers[i1], numbers[i], numbers[i3], numbers[i2]);
        //                        isResult = true;

        //                    }
        //                    else if (numbers[i] + numbers[i1] == numbers[i3] + numbers[i2])
        //                    {
        //                        Console.WriteLine("{0}|{1}=={2}|{3}", numbers[i], numbers[i1], numbers[i3], numbers[i2]);
        //                        isResult = true;

        //                    }
        //                }
        //            }
        //        }
        //    }
        //}
        //if (!isResult)
        //{
        //    Console.WriteLine("No");
        //}


        //Problem 10

        int n = int.Parse(Console.ReadLine());
        int[] matrix = new int[n];
        bool isResult = false;
        for (int i = 0; i < n; i++)
        {
            matrix[i] = int.Parse(Console.ReadLine());
        }
        for (int a = 0; a < n; a++)
        {
            for (int b = 0; b < n; b++)
            {
                for (int c = 0; c < n; c++)
                {
                    if (matrix[a]<=matrix[b] && matrix[c]>=matrix[b])
                    {
                        if (matrix[a]*matrix[a] + matrix[b]*matrix[b] == matrix[c]*matrix[c])
                        {
                            Console.WriteLine("{0}*{0} + {1}*{1} = {2}*{2}", matrix[a], matrix[b], matrix[c]);
                            isResult = true;
                        }
                    }
                }
            }
        }
        if (!isResult)
        {
            Console.WriteLine("No");
        }
    }
}
