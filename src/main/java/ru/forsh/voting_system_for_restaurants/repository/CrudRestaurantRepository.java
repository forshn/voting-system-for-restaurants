package ru.forsh.voting_system_for_restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.forsh.voting_system_for_restaurants.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.meals WHERE r.id =:id")
    Restaurant getWithMeals(@Param("id") int id);

    @Query("""
            SELECT r FROM Restaurant r 
            LEFT JOIN FETCH r.meals d            
            WHERE r.id =:id AND d.added=:date
            ORDER BY d.added DESC
            """)
    Restaurant getWithMealsByDate(@Param("id") int id, @Param("date") LocalDate date);

    @Query("""
            SELECT DISTINCT r FROM Restaurant r 
            LEFT JOIN FETCH r.meals d 
            WHERE d.added=:date
            ORDER BY r.name
            """)
    List<Restaurant> getAllWithMealsByDate(@Param("date") LocalDate date);
}