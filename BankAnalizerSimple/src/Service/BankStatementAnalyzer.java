package Service;
import Enteties.BankStatement;


public interface BankStatementAnalyzer {

    void PrintStatement(BankStatement bankStatement);
    void analyzeStatement(BankStatement bankStatement);
}