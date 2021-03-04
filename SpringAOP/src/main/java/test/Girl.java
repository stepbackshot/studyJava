package test;

import org.springframework.stereotype.Component;

/**
 * @author Harden
 * @title: Girl
 * @date 2021年02月23日 22:20
 */
@Component
public class Girl implements IBuy {
    @Override
    public String buy() {
        System.out.println("女孩买了一件漂亮的衣服");
        return "衣服";
    }
}
