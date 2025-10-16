package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_test_case1() {
        Team team1 = new Team("lol");
        //Team team2 = new Team("jol", List.of("Sam", "Tom"));
        assertTrue(team1.equals(team1), "Same object return true");
    }

    @Test
    public void equals_test_case2() {
        Team team1 = new Team("lol");
        String team2 = "Hi";
        //Team team2 = new Team("jol", List.of("Sam", "Tom"));
        assertFalse(team1.equals(team2), "Different object classes return false");
    }

    @Test
    public void equals_test_case3_1() {
        Team team1 = new Team("lol");
        Team team2 = new Team("lol");
        //Team team2 = new Team("jol", List.of("Sam", "Tom"));
        assertTrue(team1.equals(team2), "Different objects with same attributes return true");
    }

    @Test
    public void equals_test_case3_2() {
        Team team1 = new Team("lol");
        Team team2 = new Team("lollll");
        //Team team2 = new Team("jol", List.of("Sam", "Tom"));
        assertFalse(team1.equals(team2), "Different object with diff attributes return false");
    }

    @Test
    public void equals_test_case3_3() {
        Team team1 = new Team("lol");
        team1.addMember("sam");
        Team team2 = new Team("lol");
        team1.addMember("tom");
        //Team team2 = new Team("jol", List.of("Sam", "Tom"));
        assertFalse(team1.equals(team2), "Different object with diff attributes return false");
    }

    // @Test
    // public void equals_test_case3_4() {
    //     Team team1 = new Team("lol");
    //     team1.addMember("sam")
    //     Team team2 = new Team("loll");
    //     team1.addMember("sam")
    //     //Team team2 = new Team("jol", List.of("Sam", "Tom"));
    //     assertFalse(team1.equals(team2), "Different object with diff attributes return false");
    // }

    @Test
    public void hashCode_equals() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_other_test() {
        Team t = new Team("po");
        int result = t.hashCode();
        int expectedResult = 3583;
        assertEquals(expectedResult, result);
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
