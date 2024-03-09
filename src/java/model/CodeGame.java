/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thanh
 */
public class CodeGame {

    private String gameName;
    private String CodeID;
    private int GameID;
    private String Code;
    private int Status;

    public CodeGame() {
    }

    public CodeGame(String gameName, String CodeID, int GameID, String Code, int Status) {
        this.gameName = gameName;
        this.CodeID = CodeID;
        this.GameID = GameID;
        this.Code = Code;
        this.Status = Status;
    }

    public CodeGame(String CodeID, int GameID, String Code, int Status) {
        this.CodeID = CodeID;
        this.GameID = GameID;
        this.Code = Code;
        this.Status = Status;
    }

    public CodeGame(String CodeID, String Code, int Status) {
        this.CodeID = CodeID;
        this.Code = Code;
        this.Status = Status;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getCodeID() {
        return CodeID;
    }

    public void setCodeID(String CodeID) {
        this.CodeID = CodeID;
    }

    public int getGameID() {
        return GameID;
    }

    public void setGameID(int GameID) {
        this.GameID = GameID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
