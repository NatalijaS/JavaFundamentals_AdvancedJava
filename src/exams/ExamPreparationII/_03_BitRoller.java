package exams.ExamPreparationII;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03_BitRoller {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int pillarPosition = Integer.parseInt(reader.readLine());
        int rolls = Integer.parseInt(reader.readLine());

//        System.out.println(Integer.toString(n, 2).PadLeft(19, '0'));

        for (int i = 0; i < rolls; i++)
        {
            n = RollBitsRight(n, pillarPosition);
            //Console.WriteLine(Convert.ToString(n, 2).PadLeft(SIZE, '0'));
        }

        System.out.println(n);
    }

    public static int RollBitsRight(int n, int pillarPosition){
        int result = 0;
        for (int pos = 0; pos < 19; pos++)
        {
            int bit = (n >> pos) & 1;
            if (pos == pillarPosition)
            {
                //newBits[pos] = bits[pos];
                result = result | (bit << pos);
            }
            else
            {
                int newPos = RightPosition(pos);
                if (newPos == pillarPosition)
                {
                    newPos = RightPosition(newPos);
                }
                //newBits[newPos] = bits[pos];
                result = result | (bit << newPos);
            }
        }

        return result;
    }

    public static int RightPosition(int pos){
        int newPos = pos - 1;
        if (newPos < 0)
        {
            newPos = 19 - 1;
        }
        return newPos;
    }

}
