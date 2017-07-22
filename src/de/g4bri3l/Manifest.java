package de.g4bri3l;

import java.util.List;

public class Manifest {

    MinecraftData minecraft;
    String manifestType;
    int manifestVersion;
    String name;
    String version;
    String author;
    int projectID;
    FileData files;

    String getForgeVersion() {
        for (MinecraftData.Modloader modloader : minecraft.modloaders) {
            if (modloader.id.startsWith("forge-")) {
                return modloader.id.substring("forge-".length());
            }
        }
        return "N/A";
    }

    public static class MinecraftData {

        String version;
        List<Modloader> modloaders;

        private class Modloader {

            String id;
            boolean primary;

        }
    }

    private class FileData {

        int projectID;
        int fileID;
        boolean required;

        @Override
        public String toString() {
            return projectID + "/" + fileID;
        }

    }
}
