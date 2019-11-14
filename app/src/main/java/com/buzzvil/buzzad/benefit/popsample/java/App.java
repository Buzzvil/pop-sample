package com.buzzvil.buzzad.benefit.popsample.java;

import android.app.Application;
import com.buzzvil.buzzad.benefit.BuzzAdBenefit;
import com.buzzvil.buzzad.benefit.BuzzAdBenefitConfig;
import com.buzzvil.buzzad.benefit.core.models.UserProfile;
import com.buzzvil.buzzad.benefit.presentation.pop.PopConfig;
import com.buzzvil.buzzad.benefit.presentation.pop.SidePosition;

public class App extends Application {

    public static final String APP_ID = "YOUR_APP_ID";
    public static final String UNIT_ID_POP = "YOUR_POP_UNIT_ID";

    @Override
    public void onCreate() {
        super.onCreate();

        initBuzzAdBenefit();
    }

    private void initBuzzAdBenefit() {
        final PopConfig popConfig = new PopConfig.Builder(UNIT_ID_POP)
                .initialSidePosition(new SidePosition(SidePosition.Side.RIGHT, 0.6f))
                .initialPopIdleMode(PopConfig.PopIdleMode.INVISIBLE)
                .build();

        final BuzzAdBenefitConfig buzzAdBenefitConfig = new BuzzAdBenefitConfig.Builder(APP_ID)
                .add(UNIT_ID_POP, popConfig)
                .build();
        BuzzAdBenefit.init(this, buzzAdBenefitConfig);

        final UserProfile userProfile = new UserProfile.Builder(BuzzAdBenefit.getUserProfile())
                .userId("SAMPLE_USER_ID")
                .gender(UserProfile.Gender.FEMALE)
                .birthYear(1993)
                .build();
        BuzzAdBenefit.setUserProfile(userProfile);
    }
}
