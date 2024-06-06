import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class SizeOf {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar sizeOf.jar [-r] <directory>");
            return;
        }

        boolean recursive = false;
        String directory;

        if (args.length == 2 && args[0].equals("-r")) {
            recursive = true;
            directory = args[1];
        } else {
            directory = args[0];
        }

        Path startPath = Paths.get(directory);
        SizeCalculator sizeCalculator = new SizeCalculator(recursive);

        try {
            Files.walkFileTree(startPath, sizeCalculator);

            Map<String, Long> fileSizes = sizeCalculator.getFileSizes();
            long totalSize = sizeCalculator.getTotalSize();

            for (Map.Entry<String, Long> entry : fileSizes.entrySet()) {
                String key = entry.getKey();
                Long value = entry.getValue();
                System.out.printf("%s: %.1f kB%n", key, value / 1024.0);
            }

            System.out.printf("Total: %.1f kB%n", totalSize / 1024.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
