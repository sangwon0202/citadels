package sangwon.citadels.characterPick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharacterPick2 implements CharacterPick {

    private int turn;
    private List<TurnInfo> turnInfoList;
    private List<Integer> cards;
    private List<List<Integer>> result;

    public CharacterPick2() {

        // turn & turnInfoList 초기화
        turnInfoList = new ArrayList<>();
        turnInfoList.add(new TurnInfo(1,PickStatus.PICK));
        turnInfoList.add(new TurnInfo(2,PickStatus.PICK));
        turnInfoList.add(new TurnInfo(2,PickStatus.DISCARD));
        turnInfoList.add(new TurnInfo(1,PickStatus.PICK));
        turnInfoList.add(new TurnInfo(1,PickStatus.DISCARD));
        turnInfoList.add(new TurnInfo(2,PickStatus.PICK));
        turnInfoList.add(new TurnInfo(0,PickStatus.END));

        turn = 0;

        // cards 초기화
        cards = new ArrayList<>();
        Random rd = new Random();
        int discard = rd.nextInt(8) + 1;
        for(int i=1; i<=8; i++) {
            if(i != discard) {
                cards.add(i);
            }
        }

        // result 초기화
        result = new ArrayList<>(3);
    }

    @Override
    public List<Integer> getFaceUp() {
        return new ArrayList<>();
    }

    @Override
    public TurnInfo getCurrentTurnInfo() {
        return turnInfoList.get(turn);
    }

    @Override
    public List<Integer> getCards(){
        return cards;
    }

    @Override
    public void pick(int player, int card) throws Exception {
        discard(player, card);
        result.get(player).add(card);
    }

    @Override
    public void discard(int player, int card) throws Exception {
        TurnInfo turnInfo = getCurrentTurnInfo();
        if(turnInfo.getPickStatus() == PickStatus.END) throw new Exception();
        if(turnInfo.getPlayer() != player) throw new Exception();
        if(!cards.contains(card)) throw new Exception();

        cards.remove(Integer.valueOf(card));
    }

    @Override
    public boolean isEnd() {
        return getCurrentTurnInfo().getPickStatus() == PickStatus.END;
    }

    @Override
    public List<List<Integer>> getResult() {
        return result;
    }

}
