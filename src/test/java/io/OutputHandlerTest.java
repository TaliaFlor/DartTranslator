//package io;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class OutputHandlerTest {
//
//    OutputHandler handler;
//
//    @BeforeEach
//    void setUp() {
//        handler = new OutputHandler();
//    }
//
//    @AfterEach
//    void tearDown() {
//        handler = null;
//    }
//
//    @Test
//    void testReadLineComString() {
//        String line = "print('Escolha um número:');";
//
//        handler.readLine(line);
//    }
//
//    @Test
//    void testReadLineComNumero() {
//        String line = "print(1);";
//
//        handler.readLine(line);
//    }
//
//    @Test
//    void testReadLineComBoolean() {
//        String line = "print(true);";
//
//        handler.readLine(line);
//    }
//
//    @Test
//    void testReadLineComVariavel() {
//        String line = "print(variavel1);";
//
//        handler.readLine(line);
//    }
//}