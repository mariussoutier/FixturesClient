package your.app.components;

import your.app.model.Movie;
import your.app.model.MovieRole;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;

public class Main extends ERXComponent {
	public MovieRole movieRoleItem;

	public Main(WOContext context) {
		super(context);
	}

	public NSArray<MovieRole> movieRoles() {
		return MovieRole.fetchAllMovieRoles(this.session().defaultEditingContext(), MovieRole.MOVIE.dot(Movie.YEAR_KEY).ascs());
	}

	public WOActionResults reloadAction() {
		return null;
	}

	@Override
	public boolean synchronizesVariablesWithBindings() {
		return false;
	}
}
