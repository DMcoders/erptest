package com.example.erp01.model;

public class Match {

    private Integer matchID;

    private String tailornormalQcode;

    private String tailoropaQcode;

    public Match(String tailornormalQcode, String tailoropaQcode) {
        this.tailornormalQcode = tailornormalQcode;
        this.tailoropaQcode = tailoropaQcode;
    }

    public Integer getMatchID() {
        return matchID;
    }

    public void setMatchID(Integer matchID) {
        this.matchID = matchID;
    }

    public String getTailornormalQcode() {
        return tailornormalQcode;
    }

    public void setTailornormalQcode(String tailornormalQcode) {
        this.tailornormalQcode = tailornormalQcode;
    }

    public String getTailoropaQcode() {
        return tailoropaQcode;
    }

    public void setTailoropaQcode(String tailoropaQcode) {
        this.tailoropaQcode = tailoropaQcode;
    }
}
