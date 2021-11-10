package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        GameCount gameCount = new GameCount(purchaseAmount);
        ManualGameCount manualGameCount = InputView.inputPurchaseManualGameCount(gameCount);
        ResultView.printPurchasedGameCount(gameCount.getValue(), manualGameCount.getValue());
        ManualGames manualGames = InputView.inputManualGameNumbers(manualGameCount.getValue());
        Games games = new Games(gameCount.getValue(), manualGames.getList());
        LottoNumbers winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber(winningNumbers);
        Checker checker = new Checker(games, winningNumbers, bonusNumber);
        ResultView.printResult(checker.getResults());
        ResultView.printEarningRate(purchaseAmount);
    }

}
