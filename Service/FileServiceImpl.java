package com.projects.testdm.Service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {
    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch(java.io.IOException e) {
            // nie rob nic? po prostu nie tworz folderu
            System.out.println("Folder już istnieje lub wystąpił problem z dostępem do systemu plików.");
        }
        catch(Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (java.io.IOException e){
            System.out.println("Wystąpił problem przy zapisie pliku.");
        }
        catch (Exception e){
            System.out.println("Wystąpił problem z czymś innym");
            e.printStackTrace();
        }
    }

    @Override
    public Resource download(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("cant read file");
            }
        } catch(java.net.MalformedURLException e){
            System.out.println("Wystąpił problem z URL:" + e.getMessage());
            return null;
        }
        catch (Exception e) {
            System.out.println("Wystąpił problem: ");
            e.printStackTrace();
            return null;
        }
        }

    @Override
    public void deleteAll() {
        try {
            FileSystemUtils.deleteRecursively(root.toFile());
        } catch(Exception e){
            System.out.println("Wystapił błąd");
            e.printStackTrace();
        }
    }

    @Override
    public List<Path> getAll() {
        try {
            return (List<Path>) Files.list(this.root);
        } catch(java.io.IOException e){
            System.out.println("Wystąpił błąd podczas pobierania plików");
            throw new RuntimeException("cant get files");
        } catch (Exception e) {
            System.out.println("Wystąpił błąd podczas pobierania plików inny niż IOException: "+e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("cant get files");
        }
        }
    }




