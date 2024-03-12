package sangwon.citadels.characterPick;

import java.util.List;

public interface CharacterPick {

    // 처음 오픈한 카드 목록
    List<Integer> getFaceUp();

    // 현재 턴 정보
    TurnInfo getCurrentTurnInfo();

    // 현재 고를 수 있는 카드 목록
    List<Integer> getCards();

    // 선택
    void pick(int player, int card) throws Exception;

    //버리기
    void discard(int player, int card) throws Exception;

    // 선택 종료 체크
    boolean isEnd();

    // 최종 결과
    List<List<Integer>> getResult() throws Exception;

}
