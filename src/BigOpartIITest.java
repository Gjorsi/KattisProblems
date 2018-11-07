

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Torstein Strømme
 */
public class BigOpartIITest {

    final int N = 100, M = 100;
    
    private BigOTest bigO;

    @BeforeEach
    void createArray() {
        this.bigO = new BigOTest();
    }

    @Test
    void testA() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.a(i, j);
                assertEquals(funcA(i, j), this.bigO.tally());
            }
        }
    }

    @Test
    void testB() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.b(i, j);
                assertEquals(funcB(i, j), this.bigO.tally());
            }
        }
    }

    @Test
    void testC() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.c(i, j);
                assertEquals(funcC(i, j), this.bigO.tally());
            }
        }
    }
    
    @Test
    void testD() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.d(i, j);
                try {
                    assertEquals(funcD(i, j), this.bigO.tally());
                } catch (AssertionError e) {
                    System.out.println(e);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testE() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                this.bigO.e(i, j);
                try {
                    assertEquals(funcE(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testF() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                this.bigO.f(i, j);
                try {
                    assertEquals(funcF(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testH() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                this.bigO.h(i, j);
                try {
                    assertEquals(funcH(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testI() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                this.bigO.i(i, j);
                try {
                    assertEquals(funcI(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testJ() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                this.bigO.j(i, j);
                try {
                    assertEquals(funcJ(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testK() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.k(i, j);
                try {
                    assertEquals(funcK(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testL() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.l(i, j);
                try {
                    assertEquals(funcL(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testM() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.m(i, j);
                try {
                    assertEquals(funcM(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testN() {
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= M; j++) {
                this.bigO.n(i, j);
                try {
                    assertEquals(funcN(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("testN failed at n=" + i + " , m=" + j);
                    return;
                }
                
            }
        }
    }
    
    @Test
    void testO() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                this.bigO.o(i, j);
                try {
                    assertEquals(funcO(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("testO failed at n=" + i + " , m=" + j);
                    throw err;
                }
                
            }
        }
    }
    
    @Test
    void testP() {
        for (int i = 1; i <= N/20; i++) {
            for (int j = 2; j <= M/20; j++) {
                this.bigO.p(i, j);
                try {
                    assertEquals(funcP(i, j), this.bigO.tally());
                } catch (AssertionError err) {
                    System.out.println(err);
                    System.out.println("testP failed at n=" + i + " , m=" + j);
                    throw err;
                }
                
            }
        }
    }

    private int funcA(int n, int m) {
        return 2 * n + m;
    }
    
    private int funcB(int n, int m) {
        return n*m+n;
    }
    
    private int funcC(int n, int m) {
        return Math.min(n, m);
    }
    
    private int funcD(int n, int m) {
        return ((int)log2(n))*m+m;
    }
    
    private int funcE(int n, int m) {
        return 1;
    }
    
    private int funcF(int n, int m) {
        return n*m+(int)Math.ceil((double)n/2);
    }
    
    private int funcG(int n, int m) {
        return 0;
    }
    private int funcH(int n, int m) {
        return n+m;
    }
    private int funcI(int n, int k) {
        return (int)((double)((n*(n+1))/2))*k;
    }
    private int funcJ(int n, int k) {
        return (2*((int)Math.pow(n, 2)))+(2*n*k)+((int)Math.pow(k, 2));
    }
    
    private int funcK(int n, int m) {
        return n+m;
    }
    
    private int funcL(int n, int m) {
        return n+m;
    }
    
    private int funcM(int n, int m) {
        return (int)Math.ceil((double)m/n);
    }
    
    private int funcN(int n, int k) {
        return (int)(Math.log(n)/Math.log(k))+1;
    }
    
    private int funcO(int n, int k) {
        return (int)Math.ceil((double)n/(2*k));
    }
    
    private int funcP(int n, int k) {
        int res = 0;
        
        for (int i=0; i<n; i++) {
            res += (int)Math.pow(k, i);
        }
        return res;
    }
    
    private double log2(int x) {
        return Math.log(x)/Math.log(2.0);
    }
}
