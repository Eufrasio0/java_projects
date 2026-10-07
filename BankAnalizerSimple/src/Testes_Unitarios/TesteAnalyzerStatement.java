package Testes_Unitarios;

import Interfaces.BankStatementAnalyzer;
import Service.BankStatementServices;
import Service.ReadBankStatementCSVParser;
import Enteties.BankStatement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteAnalyzerStatement {

    @Test
    void AnalyzerStatementCSVPicPay() throws Exception {

        // Arrange
        BankStatement bankStatement = new BankStatement();

        ReadBankStatementCSVParser parser =
            new ReadBankStatementCSVParser(
                "C:/Users/Eufrasio/OneDrive/Desktop/Java/BankAnalizerSimple/src/Repositories/csv/ExtratoRealPicPay2.csv"
            );

        parser.ChargeBankStatement(bankStatement);

        BankStatementAnalyzer analyzer =
            new BankStatementServices();

        // Act
        analyzer.analyzeStatement(bankStatement);

        // Assert
        // depende do que analyzeStatement altera no BankStatement
    }
}

