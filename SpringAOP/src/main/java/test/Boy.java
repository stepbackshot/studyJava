package test;

import org.springframework.stereotype.Component;

/**
 * @author Harden
 * @title: Boy
 * @date 2021年02月23日 22:18
 */
@Component
public class Boy implements IBuy {

    public String buy() {
        System.out.println( "男孩买了一个游戏机🎮" );
        return "游戏机🎮";
    }
}
