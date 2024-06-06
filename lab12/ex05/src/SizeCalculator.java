import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class SizeCalculator implements FileVisitor<Path> {

    private Map<String, Long> fileSizes = new HashMap<>();
    private long totalSize = 0;
    private boolean recursive;

    public SizeCalculator(boolean recursive) {
        this.recursive = recursive;
    }

    public Map<String, Long> getFileSizes() {
        return fileSizes;
    }

    public long getTotalSize() {
        return totalSize;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        if (!recursive && !dir.equals(dir.getRoot())) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        fileSizes.put(dir.toString(), 0L);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        long size = attrs.size();
        totalSize += size;

        Path parent = file.getParent();
        if (fileSizes.containsKey(parent.toString())) {
            fileSizes.put(parent.toString(), fileSizes.get(parent.toString()) + size);
        } else {
            fileSizes.put(parent.toString(), size);
        }

        fileSizes.put(file.toString(), size);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }
}
