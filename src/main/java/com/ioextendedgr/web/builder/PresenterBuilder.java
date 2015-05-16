package com.ioextendedgr.web.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.ioextendedgr.web.data.Presenter;
import com.ioextendedgr.web.data.User;
import com.ioextendedgr.web.viewDto.PresenterView;

public class PresenterBuilder {

	public static Collection<PresenterView> build(Collection<Presenter> dtos,
			Collection<User> userDtos) {
		List<PresenterView> presenters = new ArrayList<PresenterView>();

		for (Presenter currPresenter : dtos) {
			User user = findUserById(currPresenter.getId(), userDtos);
			presenters.add(build(currPresenter, user));
		}

		return presenters;
	}

	public static PresenterView build(Presenter dto, User userDto) {
		PresenterView presenter = new PresenterView();

		presenter.setCompanyView(CompanyBuilder.build(dto.getCompany()));
		presenter.setId(dto.getId());
		presenter.setJobTitle(dto.getJobTitle());
		presenter.setShortBio(dto.getShortBio());
		presenter.setUserId(dto.getUserId());

		if (userDto != null) {
			presenter.setFirstName(userDto.getFirstName());
			presenter.setLastName(userDto.getLastName());
			presenter.setEmail(userDto.getEmailAddress());
		}

		return presenter;
	}

	private static User findUserById(final Integer id,
			Collection<User> userDatas) {

		if (id == null) {
			return null;
		}

		Collection<User> items = Collections2.filter(userDatas,
				new Predicate<User>() {

					@Override
					public boolean apply(User input) {
						return id.equals(input.getId());
					}
				});

		if (CollectionUtils.isEmpty(items)) {
			return null;
		}

		return items.iterator().next();

	}

}
