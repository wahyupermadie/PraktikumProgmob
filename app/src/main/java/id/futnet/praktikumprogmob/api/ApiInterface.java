package id.futnet.praktikumprogmob.api;

import java.util.List;

import id.futnet.praktikumprogmob.model.MemberResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Wahyu Permadi on 11/17/2017.
 */

public interface ApiInterface {
    @GET("member/")
    Call<List<MemberResult>> getMember();
}
