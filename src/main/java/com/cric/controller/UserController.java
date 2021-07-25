package com.cric.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cric.entity.AddPlayer;
import com.cric.entity.BallByBall;
import com.cric.entity.BatPerformance;
import com.cric.entity.BowlingPerformance;
import com.cric.entity.Match;
import com.cric.entity.MatchResult;
import com.cric.entity.Player;
import com.cric.entity.Team;
import com.cric.entity.User;
import com.cric.helper.Message;
import com.cric.repo.AddPlayerRepo;
import com.cric.repo.BallByBallRepo;
import com.cric.repo.BatPerformanceRepo;
import com.cric.repo.BowlingPerformanceRepo;
import com.cric.repo.MatchRepo;
import com.cric.repo.MatchResultRepo;
import com.cric.repo.TeamRepo;
import com.cric.repo.UserRepo;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BowlingPerformanceRepo ballPerfoRepo;
	@Autowired
	private AddPlayerRepo addPlayerRepo; 
	
	@Autowired
	private BatPerformanceRepo batRepo;
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private MatchRepo matchRepo;
	@Autowired
	private TeamRepo teamRepo;
	
	private MatchResultRepo matchResultRepo; 
	
	@Autowired
	private BallByBallRepo bRepo;
	//for comman data
	public void addCommonData(Model model, Principal principal) 
	{
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		System.out.println(user);
		model.addAttribute("user", user);
	}
	
	// dashboard Home
	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) 
	{
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		System.out.println(user);
		model.addAttribute("user", user);
		model.addAttribute("title","User_Dashboard");
		
		return "normal/user_dashboard";
	}
	//open add form handler
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model, Principal principal) 
	{
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		System.out.println(user);
		model.addAttribute("user", user);
		model.addAttribute("title","Add Team");
		return "normal/add_contact_form";
		
	}

	@PostMapping("/saveteam")
	public String team(@ModelAttribute Team team,Principal principal,Model model, HttpSession session) {
		try {
			
			String tname=team.getName();
		   	session.setAttribute("tname", tname);
			String name=principal.getName();
			User user=this.userRepo.getUserByUserName(name);
			team.setUser(user);
			user.getTeams().add(team);
			this.userRepo.save(user);
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("succesfull register team","alert-succes"));
			return "normal/AddPlayer";
				
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("team",team);
			session.setAttribute("message", new Message("something went wrong"+e.getMessage(),"alert-danger"));
			return "normal/add_contact_form";
		}
		
		
	}
	
	@GetMapping("/viewteam")
	public String viewTeam(Model model, Principal principal) 
	{
		try {
		String userName=principal.getName();
		User user= this.userRepo.getUserByUserName(userName);
		System.out.println(user);
		model.addAttribute("user", user);
		List<Team> teams =this.teamRepo.findTeamByUser(user.getId());
		model.addAttribute("title","view Team");
		model.addAttribute("teams", teams);
		
		
		}catch(Exception e) {}
		return "normal/view_team";
	}
	
	@PostMapping("/score")
	public String score(@ModelAttribute Match match, Model model, Principal principal, HttpSession session) 
	{
		
		String userName=principal.getName();
		List<String> team1Player=new ArrayList<>();
		User user= this.userRepo.getUserByUserName(userName);
		List<Team> team=teamRepo.findAll();
		for(Team t:team) 
		{
			if(t.getName().equals(match.getTeam1())) 
			{
				match.setInning(1);
				int teamid=t.getTeamId();
				ArrayList<AddPlayer> player2=addPlayerRepo.findAllByTeamId(teamid);
				session.setAttribute("player2",player2 );	
			}
			if(t.getName().equalsIgnoreCase(match.getTeam2())) 
			{	
				int teamid=t.getTeamId();
				ArrayList<AddPlayer> player1=addPlayerRepo.findAllByTeamId(teamid);
				session.setAttribute("player1",player1 );	
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("title","scorecard");
		session.setAttribute("match", match);
		matchRepo.save(match);
		return "normal/player";
		
	}
	@PostMapping("/savescore")
	public String saveScore(Model model, Principal principal,@ModelAttribute BallByBall b ,  @RequestParam(value="wide",defaultValue="false") boolean wide ,  @RequestParam(value="noball",defaultValue="false") boolean noball, @RequestParam(value="wicket",defaultValue="false") boolean wicket, HttpServletRequest req) 
	{
			
		try {
			
			boolean bat=false;
			boolean bowler=false;
			int pid=0;
			int bid=0;
			BowlingPerformance ballPerfo=new BowlingPerformance();
			BatPerformance bPerfo=new BatPerformance();
			Match match=(Match) req.getSession().getAttribute("match");
			Player player=(Player) req.getSession().getAttribute("player");
			int run=0;
			if(match.getInning()==1) 
			{
				List<AddPlayer> strName= (List<AddPlayer>) req.getSession().getAttribute("player2");
				for(AddPlayer ad:strName) {
					if(ad.getPlayerName().equals(player.getStriker())) 
					{
						pid=ad.getPlayerId();
					}
				}
			}
			if(match.getInning()==2) 
			{
				List<AddPlayer> strName= (List<AddPlayer>) req.getSession().getAttribute("player1");
				for(AddPlayer ad:strName) {
					if(ad.getPlayerName().equals(player.getStriker())) 
					{
						pid=ad.getPlayerId();
					}
				}
			}
			BatPerformance bt=null;
			try {
			List<BatPerformance> batP= batRepo.findByMatchId(match.getmId());
			System.out.print(batP);
			for(BatPerformance bt1:batP) {
				if(bt1.getpId()==pid) 
				{
					bat=true;
					bt=bt1;
				}
			
			}
			}catch(Exception e) {
				System.out.println(e);
			}
			if(match.getInning()==1) 
			{
				List<AddPlayer> strName= (List<AddPlayer>) req.getSession().getAttribute("player1");
				for(AddPlayer ad:strName) {
					if(ad.getPlayerName().equals(player.getBowler())) 
					{
						bid=ad.getPlayerId();
						System.out.println("print bowler id"+bid);
					}
				}
			}
			if(match.getInning()==2) 
			{
				List<AddPlayer> strName= (List<AddPlayer>) req.getSession().getAttribute("player2");
				for(AddPlayer ad:strName) {
					if(ad.getPlayerName().equals(player.getBowler())) 
					{
						bid=ad.getPlayerId();
						System.out.println("print bowler id"+bid);
					}
				}
			}
			BowlingPerformance bperfm = null;
			try {
			
			List<BowlingPerformance> bowlingPerfor= ballPerfoRepo.findBymId(match.getmId());
			
			for(BowlingPerformance bperf1:bowlingPerfor) 
			{
				if(bperf1.getPlayerId()==bid) 
				{
					bowler=true;
					bperfm=bperf1;
					System.out.println("trueee");
				}
			}
			}catch(Exception e) {
				System.out.print("hellllo");
			}
		    if(wide){
		    	b.setRun(0);
				b.setExtra(1);
				b.setBallType("w");
				player.thisOver.add(b.getBallType());
			}
			else if(noball) {
				b.setRun(0);
				b.setExtra(1);
				b.setBallType("NB");
				player.thisOver.add(b.getBallType());			
			}
			else if(wicket) {
				b.setRun(0);
				b.setExtra(0);
				match.setBall(match.getBall()+1);
				b.setBallType("wk");
				player.setWiket(player.getWiket()+1);
				player.thisOver.add(b.getBallType());
				
			}
			else {
				match.setBall(match.getBall()+1);
				b.setExtra(0);
				b.setBallType(String.valueOf(b.getRun()));
				player.thisOver.add(b.getBallType());
				run=b.getRun();
				player.setsRun(player.getsRun()+run);
				player.setSball(player.getSball()+1);
				
								
				if(bat==true) 
				{
					bPerfo.setBatId(bt.getBatId());					
					bPerfo.setpId(bt.getpId());
					bPerfo.setPlayerName(bt.getPlayerName());
					bPerfo.setMatchId(bt.getMatchId());
					bPerfo.setRuns(player.getsRun());
					bPerfo.setBalls(player.getSball());
					bPerfo.setInning(match.getInning());
					batRepo.save(bPerfo);
				}
				else 
				{
					bPerfo.setpId(pid);
					bPerfo.setPlayerName(player.getStriker());
					bPerfo.setMatchId(match.getmId());
					bPerfo.setRuns(player.getsRun());
					bPerfo.setBalls(player.getSball());
					bPerfo.setInning(match.getInning());
					batRepo.save(bPerfo);
				} 
				
				
				if(bowler) 
				{
					ballPerfo.setbPerformId(bperfm.getbPerformId());
					ballPerfo.setMaiden(0);
					ballPerfo.setmId(match.getmId());
					ballPerfo.setPlayerId(bid);
					ballPerfo.setRuns(bperfm.getRuns()+run+b.getExtra());
					ballPerfo.setWicket(player.getWiket());
					player.setbRun(bperfm.getRuns()+run+b.getExtra());
					if(match.getBall()==6) 
					{
						int a=(int) bperfm.getOver();
						ballPerfo.setOver(a+1);
						player.setBover(0);
					}
					else {
					ballPerfo.setOver(bperfm.getOver()+0.1f);
					player.setBover(ballPerfo.getOver());
					}
					ballPerfoRepo.save(ballPerfo);
					
				}
				else 
				{
					ballPerfo.setMaiden(0);
					ballPerfo.setmId(match.getmId());
					ballPerfo.setPlayerId(bid);
					ballPerfo.setRuns(b.getRun()+b.getExtra());
					ballPerfo.setOver(0.1f);
					player.setbRun(ballPerfo.getRuns());
					player.setBover(ballPerfo.getOver());
					ballPerfo.setWicket(player.getWiket());
					ballPerfoRepo.save(ballPerfo);
				}
				
				/*bPerfo.setpId(pid);
				bPerfo.setPlayerName(player.getStriker());
				bPerfo.setMatchId(match.getmId());
				bPerfo.setRuns(player.getsRun());
				bPerfo.setBalls(player.getSball());
				bPerfo.setInning(match.getInning());
				batRepo.save(bPerfo); */
				if(b.getRun()==1 || b.getRun()==3) {
					String s=player.getStriker();
					player.setStriker(player.getNonstriker());
					player.setNonstriker(s);
					int xr=player.getsRun();
					player.setsRun(player.getnSRun());
			    	player.setnSRun(xr);
			    	int x=player.getNsBall();
			    	player.setNsBall(player.getSball());
			    	player.setSball(x);
			    }
			}
		   float crt=match.getTotal()/match.getOver();
		    model.addAttribute("crt", crt);
			model.addAttribute("player", player);
			System.out.println(b.getRun());
			String userName=principal.getName();
			User user= this.userRepo.getUserByUserName(userName);
			b.setBowlerId(bid);
			b.setPlayerId(pid);
			if(match.getInning()==2) 
			    {
			    	model.addAttribute("t1", match.getTotal1());
			    }
			match.setTotal(match.getTotal()+b.getRun()+b.getExtra());
			b.setMatchId(match.getmId());
			bRepo.save(b);
			List<BallByBall> b1= this.bRepo.findByMatchId(1);
			model.addAttribute("b1", b1);
			model.addAttribute("user", user);
			model.addAttribute("title","scoring");
			model.addAttribute("match", match);
			if(match.getInning()==1) {
			match.setTotal1(match.getTotal());
			match.setT1over(match.getT1over()+0.1f);
			matchRepo.save(match);
			}
			else 
			{
				match.setT2over(match.getT2over()+0.1f);
				match.setTotal2(match.getTotal());
				matchRepo.save(match);
			}
			if(match.getBall()==6) 
			{	
				player.thisOver.clear();
				match.setBall(0);
				player.setOver(player.getOver()+1);
				if(match.getInning()==1) 
				{
					match.setT1over(player.getOver());
					if(player.getOver()<2 ) {
						
						return "normal/nextbowler";
					}
				}
				if( match.getInning()==2) {
					int x=(int)match.getT2over();
					match.setT2over(x+1);
				if(player.getOver()<2) 
				{
					
					return "normal/nextbowler";
				}
				}
			}
			if(match.getInning()==2) 
			{
				if(match.getTotal1()-match.getTotal()<0 || player.getWiket()==10 || player.getOver()==2) 
				{
					return "normal/congratulation";
				}
				if(match.getTotal()>match.getTotal1()) 
				{
					return "normal/congratulation";
				}
			}
			if(match.getInning()==1) {
			if(player.getWiket()==10 || player.getOver()==2 ) 
			{
				player.setWiket(0);
				player.setOver(0);
				match.setTotal1(match.getTotal());
				match.setTotal(0);
				match.setInning(2);
				return "normal/player";
			}
			}
			return "normal/scorecard";
		}catch(Exception e) 
		{
			String userName=principal.getName();
			User user= this.userRepo.getUserByUserName(userName);
			model.addAttribute("user", user);
			return "normal/match";
		}
		
	}
	
	@GetMapping("/match")
	public String match(Model model, Principal principal) 
	{
		try {
		String userName=principal.getName();
		User user= this.userRepo.getUserByUserName(userName);
		model.addAttribute("user", user);
		model.addAttribute("title","create-match");
		return "normal/match";
		}catch(Exception e) {
			return "normal/dashboard";
		}
	}
	
	@PostMapping("/player")
	public String player(@ModelAttribute Player player, Model model, Principal principal,HttpServletRequest req) 
	{
		try {
		String userName=principal.getName();
		User user= this.userRepo.getUserByUserName(userName);
		model.addAttribute("user", user);
		model.addAttribute("title","scorecard");
		Match match=(Match) req.getSession().getAttribute("match");
		req.getSession().setAttribute("player", player);
		model.addAttribute("match", match);
		matchRepo.save(match);
		return "normal/scorecard";
		}catch(Exception e) 
		{
			return "normal/match";
		}
	}
	
	@GetMapping("/viewmatch")
	public  String viewScore(Model model, Principal principal) 
	{
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		System.out.println(user);
		List<Match> m=matchRepo.findAll();
		Collections.sort(m, Collections.reverseOrder());
		System.out.println(m);
		model.addAttribute("m", m);
		model.addAttribute("user", user);
		model.addAttribute("title","Add Team");
		return "normal/viewscore";
		
	}
	@PostMapping("/searchmatch")
	public String searchPlayer(Model model, Principal principal, @RequestParam("teamName") String name) 
	{
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		List<User> l=userRepo.findByName(name);
		model.addAttribute("l",l);
		model.addAttribute("user", user);
		model.addAttribute("title","Add Team");
		return "normal/AddPlayer";
		
	}
	@PostMapping("/nextbowler")
	public String nextBowler(Model model, Principal principal, @RequestParam("bowler") String nextBowler,HttpServletRequest req) 
	{
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		Player player=(Player) req.getSession().getAttribute("player");
		player.setBowler(nextBowler);
		model.addAttribute("player", player);
		Match match=(Match) req.getSession().getAttribute("match");
		model.addAttribute("match", match);
		model.addAttribute("user", user);
		model.addAttribute("title","Add Team");
		return "normal/scorecard";
		
	}
	
	@GetMapping("/addplayer")
	public String addPlayer(Model model, Principal principal, @RequestParam(name="playerId") int id, HttpSession session) 
	{
		
	    AddPlayer addPlayer=new AddPlayer();
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		User user1= userRepo.getUserById(id);
		String tname=(String) session.getAttribute("tname");
		Team team=teamRepo.findByName(tname);
		addPlayer.setPlayerName(user1.getName());
		addPlayer.setPlayerId(user1.getId());
		addPlayer.setPlayingOrNot("Playing");
		addPlayer.setRole("player");
		addPlayer.setTeamId(team.getTeamId());
		addPlayerRepo.save(addPlayer);
		model.addAttribute("user", user);
		model.addAttribute("title","Add Team player");
		return "normal/AddPlayer";
	
	}
	@GetMapping("/viewmatch1")
	public String viewMatch(@RequestParam(name="matchid") int id,Model model, Principal principal,HttpSession session) 
	{
		
		String userName=principal.getName();
		User user= userRepo.getUserByUserName(userName);
		model.addAttribute("user", user);
		model.addAttribute("title","Add Team player");
		String tname=(String) session.getAttribute("tname");
		ballPerfoRepo.findAll();
		return "normal/matchview";
	}

}
