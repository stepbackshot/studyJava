package test;

import org.springframework.stereotype.Component;

/**
 * @author Harden
 * @title: AfterReturn
 * @date 2021年02月24日 14:50
 */
@Component
public class AfterReturn {
    public String execute() {
        System.out.println( "executing ..." );
        return "over";
    }

    public int getValue(int i) {
        return 100 / i;
    }
}
