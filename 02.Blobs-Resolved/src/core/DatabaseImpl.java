package core;

import core.interfaces.Database;
import models.interfaces.Blob;

import java.util.*;

public class DatabaseImpl implements Database{

    private List<Blob> blobs;

    public DatabaseImpl() {
        this.setBlobs(new LinkedList<>());
    }

    @Override
    public List<Blob> getBlobs() {
        return Collections.unmodifiableList(this.blobs);
    }

    private void setBlobs(List<Blob> blobs) {
        this.blobs = blobs;
    }

    @Override
    public void addBlob(Blob blob){
        this.blobs.add(blob);
    }

    @Override
    public void removeDeadBlob(Blob blob){
        if (blob.isDead()){
            this.blobs.remove(blob);
        }
    }

    @Override
    public Blob getBlobByName(String name){
        for (Blob blob : blobs) {
            if (blob.getName().equalsIgnoreCase(name)){
                return blob;
            }
        }

        throw new IllegalArgumentException("No such Blob!");
    }
}
