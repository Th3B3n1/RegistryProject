import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        List<Registry> registries = new ArrayList<>();
        // 2.a
        registries.add(new Registry("HalászG", "NestJS is the best!"));
        registries.add(new Registry("CzinkócziT", "SEO is the best!"));

        // 2.b
        System.out.println("-----2.b-----");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bejegyzés darabszám: ");
        int registryCount = 0;
        try
        {
            registryCount = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e)
        {
            System.out.println("Egész számot adj már meg légyszi (" + e.getMessage() + ")");
        }
        for (int i = 0; i < registryCount; i++)
        {
            registries.add(new Registry("Unknown", "Bejegyzés" + i));
        }

        // 2.c
        System.out.println("-----2.c-----");
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("bejegyzesek.csv"));
            while(reader.ready())
            {
                String line = reader.readLine();
                String[] split = line.split(";");
                registries.add(new Registry(split[0], split[1]));
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        // 2.d
        Random rand = new Random();
        for (int i = 0; i < registries.size() * 20; i++)
        {
            registries.get(rand.nextInt(0, registries.size())).like();
        }

        // 2.e
        System.out.println("-----2.e-----");
        System.out.println("Random stringet kérek (nyugi nincs jelentősége :D):");
        scanner = new Scanner(System.in);
        try
        {
            String randomString = scanner.nextLine();
            registries.get(1).setContent(randomString);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // 2.f
        System.out.println("-----2.f-----");
        for (Registry registry : registries)
        {
            System.out.println(registry.toString());
        }

        // 3.a
        System.out.println("-----3.a-----");
        Registry topRegistry = registries.getFirst();
        for (Registry registry : registries)
        {
            if (registry.getLikes() > topRegistry.getLikes()) {
                topRegistry = registry;
            }
        }
        System.out.println(topRegistry.getLikes());

        // 3.b
        System.out.println("-----3.b-----");
        boolean likeCount = false;
        for (Registry registry : registries)
        {
            if (registry.getLikes() > 35) {
                likeCount = true;
                break;
            }
        }
        if (likeCount)
        {
            System.out.println("Igen");
        }
        else
        {
            System.out.println("Nem");
        }

        // 3.c
        System.out.println("-----3.c-----");
        List<Registry> registriesFiltered = new ArrayList<>();
        for (Registry registry : registries)
        {
            if (registry.getLikes() < 15)
            {
                registriesFiltered.add(registry);
            }
        }
        System.out.println(registriesFiltered.size());

        // 3.d
        System.out.println("-----3.d-----");
        List<Registry> sortedListReversed = registries;
        Collections.sort(sortedListReversed);
        List<Registry> registriesListReversed = sortedListReversed.reversed();
        for (Registry registry : registriesListReversed)
        {
            System.out.println(registry.toString());
        }
        try
        {
            FileWriter writer = new FileWriter("bejegyzesek_rendezett.txt");
            for (Registry registry : registriesListReversed)
            {
                writer.write(registry.toString() + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}