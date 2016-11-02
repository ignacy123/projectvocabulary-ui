package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.github.ignacy123.projectvocabulary.ui.domain.Invitation;

/**
 * Created by ignacy on 01.11.16.
 */
public class InvitationRestApi extends AbstractRestApi {
    public static final InvitationRestApi INSTANCE = new InvitationRestApi();

    private InvitationRestApi() {
        super();
    }

    public Invitation create(InvitationDto dto, Long groupId, String cookie) {
        return postWithCookie("/groups/" + groupId + "/invitation", dto, Invitation.class, cookie).getBody();
    }
}
