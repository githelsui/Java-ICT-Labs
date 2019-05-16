public class LifeDriver
{
    public static void main(String[] MEMES)
    {     
        Life bot = new Life("life100.txt");
        System.out.println("Generation 0");
        bot.output();
         bot.result();
         
         
        for(int i = 1; i <= 5; i++)
        {
            bot.nextGeneration();
        }
             System.out.println("Generation 5");
              bot.output();
        bot.result();
    }
}