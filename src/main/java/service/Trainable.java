package service;

import entity.train.Train;

public interface Trainable {
    Train create(Train train);

    Train update(Train train);
    Train delete(Train train);

}
