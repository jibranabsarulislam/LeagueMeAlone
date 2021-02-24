package models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel

public class SummonerDTO {
    public String accountId;    // Encrypted account ID. Max length 56 characters.
    public int profileIconId;   // ID of the summoner icon associated with the summoner.
    public long revisionDate;   // Date summoner was last modified specified as epoch milliseconds.
                                // The following events will update this timestamp: summoner name change, summoner level change, or profile icon change.
    public String name;         // Summoner name.
    public String id;           // Encrypted summoner ID. Max length 63 characters.
    public String puuid;        // Encrypted PUUID. Exact length of 78 characters.
    public long summonerLevel;  // Summoner level associated with the summoner.

    public SummonerDTO() {} // empty constructor for parcel

    public static SummonerDTO fromJson(JSONObject jsonObject) throws JSONException {
        SummonerDTO summoner = new SummonerDTO();
        summoner.accountId = jsonObject.getString("id");
        summoner.profileIconId = jsonObject.getInt("profileIconId");
        summoner.revisionDate = jsonObject.getLong("revisionDate");
        summoner.name = jsonObject.getString("name");
        summoner.id = jsonObject.getString("id");
        summoner.puuid = jsonObject.getString("puuid");
        summoner.summonerLevel = jsonObject.getLong("summonerLevel");
        return summoner;
    }
}
