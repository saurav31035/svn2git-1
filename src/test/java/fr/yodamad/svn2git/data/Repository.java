package fr.yodamad.svn2git.data;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

public class Repository {

    public String name;
    public String namespace;

    public List<String> keep = new ArrayList<>();
    public List<String> remove = new ArrayList<>();

    public List<String> allFiles() { return concat(keep.stream(), remove.stream()).collect(toList()); }

    public static Repository simple() {
        Repository repository = new Repository();
        repository.name = "simple";
        repository.namespace = "simple";
        repository.keep.add(Files.REVISION);
        return repository;
    }

    public class Files {
        public static final String REVISION = "revision.txt";
        public static final String FILE_BIN = "file.bin";
        public static final String ANOTHER_BIN = "folder/another.bin";
        public static final String JAVA = "folder/App.java";
        public static final String DEEP = "folder/subfolder/deep.file";
    }

    public class Dirs {
        public static final String FOLDER = "folder";
        public static final String SUBFOLDER = "subfolder";
    }

    public class Branches {
        public static final String MASTER = "master";
        public static final String DEV = "dev";
        public static final String FEATURE = "feature_1";
    }

    public class Tags {
        public static final String V1_0 = "v1.0";
        public static final String V1_1 = "v1.1";
    }
}
