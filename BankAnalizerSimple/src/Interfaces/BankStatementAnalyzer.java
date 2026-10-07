package Interfaces;
import Enteties.BankStatement;
import Service.ReadBankStatementCSVParser;


public interface BankStatementAnalyzer {

    double PrintStatement(BankStatement bankStatement);
    void analyzeStatement(BankStatement bankStatement);
}