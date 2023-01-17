package com.jovine.nafa.entity.Pojo;

import com.jovine.nafa.entity.Leagues;
import com.jovine.nafa.entity.Teams;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class LeagueAndTeams {
    private Long id;
    private String leagueName;
    private Leagues league;
    private List<Teams> leagueTeams;
}
