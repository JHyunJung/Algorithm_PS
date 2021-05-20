package programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgrammersTest {

    @Test
    void 문자열을정수로바꾸기() {
        Programmers test = new Programmers();
        assertEquals(test.solution("4"), 4);
    }

    @Test
    void 완주하지못한자(){
        Programmers test = new Programmers();
        assertEquals(test.solution2("try hello world"),"TrY HeLlO WoRlD");
    }
}