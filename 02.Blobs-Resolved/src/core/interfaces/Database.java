package core.interfaces;

import models.interfaces.Blob;

import java.util.List;

public interface Database {

    List<Blob> getBlobs();

    void addBlob(Blob blob);

    void removeDeadBlob(Blob blob);

    Blob getBlobByName(String name);
}
