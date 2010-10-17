package bsearch.algorithms;

import java.util.HashMap;

import org.nlogo.util.MersenneTwisterFast;

import bsearch.app.BehaviorSearchException;
import bsearch.app.SearchProtocol;
import bsearch.evaluation.SearchManager;
import bsearch.nlogolink.NetLogoLinkException;
import bsearch.representations.Chromosome;
import bsearch.representations.ChromosomeFactory;
import bsearch.space.SearchSpace;

public strictfp class RandomSearch extends AbstractSearchMethod {
	
	public RandomSearch()
	{
	}

	public String getName() {
		return "RandomSearch";
	}
	public String getDescription() {
		return "A baseline search algorithm that repeatedly tries random locations in the search space, and returns the best found.";
	}

	public void setSearchParams( HashMap<String , String> searchMethodParams ) throws SearchParameterException
	{
	}
	public HashMap<String , String> getSearchParams()
	{
		HashMap<String,String> params = new HashMap<String,String>();
		return params;
	}
	public HashMap<String , String> getSearchParamsHelp()
	{
		HashMap<String,String> params = new HashMap<String,String>();
		return params;
	}

	public void search( SearchSpace space , ChromosomeFactory cFactory, SearchProtocol protocol,
			SearchManager manager, MersenneTwisterFast rng ) throws BehaviorSearchException, NetLogoLinkException, InterruptedException
	{
    	while (!manager.searchFinished())
    	{
   			Chromosome point = cFactory.createChromosome(space, rng);
   			// Note that the archive automatically tracks the best found so far, so all we have to do is evaluate...
   			manager.computeFitnessSingle(point, protocol.fitnessSamplingReplications, rng);
    	}            
	}

}