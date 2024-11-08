package FantasticWorld;
import java.util.Stack;

public class WarlockMemeto extends CallHeroMemeto {
    private Stack<Integer> mp = new Stack<Integer>();
    public WarlockMemeto(Warlock warlock) {
        super(warlock);
    }

    @Override
    public void restore() {
        super.restore();
        ((Warlock)this.getHero()).setMp(mp.pop());
    }

    @Override
    public void save() {
        super.save();
        mp.push(((Warlock)this.getHero()).getMp());
    }
    
}
