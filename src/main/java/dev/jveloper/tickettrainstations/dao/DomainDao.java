package dev.jveloper.tickettrainstations.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface DomainDao<T> {

    Set<T> getAll(String search);

}
