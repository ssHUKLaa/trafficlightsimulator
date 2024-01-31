package SEG2106.core;
//%% NEW FILE TrafficLight BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 2 "model.ump"
// line 201 "model.ump"
public class TrafficLight implements EventHandler
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
  public enum Status { defaultMode, lowTraffic, moderateTraffic, highTraffic }
  public enum StatusDefaultMode { Null, northAndSouthGreen, northAndSouthYellow, northAndSouthRed, westAndEastYellow }
  public enum StatusLowTraffic { Null, northAndSouthArrow, northAndSouthGreenWithoutArrow, northAndSouthYellowWithoutArrow, northAndSouthRedWithoutArrow, westAndEastYellowWithoutArrow }
  public enum StatusModerateTraffic { Null, northGreenandArrow, northYellowModerate, southGreenandArrow, southYellowModerate, northAndSouthRedModerate, westAndEastYellowModerate }
  public enum StatusHighTraffic { Null, northGreenWithArrow, northYellow, northRedAndSouthGreenAndArrow, southYellow, southRed, westGreenWithoutArrow, westEastYellowWithoutArrow }
  private Status status;
  private StatusDefaultMode statusDefaultMode;
  private StatusLowTraffic statusLowTraffic;
  private StatusModerateTraffic statusModerateTraffic;
  private StatusHighTraffic statusHighTraffic;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  private TrafficLightManager trafficLightManager; 
  public TrafficLight(TrafficLightManager trafficLightManager)
  {
    this.trafficLightManager = trafficLightManager;
    setStatusDefaultMode(StatusDefaultMode.Null);
    setStatusLowTraffic(StatusLowTraffic.Null);
    setStatusModerateTraffic(StatusModerateTraffic.Null);
    setStatusHighTraffic(StatusHighTraffic.Null);
    setStatus(Status.lowTraffic);
    trafficLightManager.addEventHandler(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    if (statusDefaultMode != StatusDefaultMode.Null) { answer += "." + statusDefaultMode.toString(); }
    if (statusLowTraffic != StatusLowTraffic.Null) { answer += "." + statusLowTraffic.toString(); }
    if (statusModerateTraffic != StatusModerateTraffic.Null) { answer += "." + statusModerateTraffic.toString(); }
    if (statusHighTraffic != StatusHighTraffic.Null) { answer += "." + statusHighTraffic.toString(); }
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public StatusDefaultMode getStatusDefaultMode()
  {
    return statusDefaultMode;
  }

  public StatusLowTraffic getStatusLowTraffic()
  {
    return statusLowTraffic;
  }

  public StatusModerateTraffic getStatusModerateTraffic()
  {
    return statusModerateTraffic;
  }

  public StatusHighTraffic getStatusHighTraffic()
  {
    return statusHighTraffic;
  }

  public boolean lowTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case defaultMode:
        exitStatus();
        setStatus(Status.lowTraffic);
        wasEventProcessed = true;
        break;
      case moderateTraffic:
        exitStatus();
        setStatus(Status.lowTraffic);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean moderateTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case defaultMode:
        exitStatus();
        setStatus(Status.moderateTraffic);
        wasEventProcessed = true;
        break;
      case lowTraffic:
        exitStatus();
        setStatus(Status.moderateTraffic);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean highTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case defaultMode:
        exitStatus();
        setStatus(Status.highTraffic);
        wasEventProcessed = true;
        break;
      case lowTraffic:
        exitStatus();
        setStatus(Status.highTraffic);
        wasEventProcessed = true;
        break;
      case moderateTraffic:
        exitStatus();
        setStatus(Status.highTraffic);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean defaultMode()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case lowTraffic:
        exitStatus();
        setStatus(Status.defaultMode);
        wasEventProcessed = true;
        break;
      case moderateTraffic:
        exitStatus();
        setStatus(Status.defaultMode);
        wasEventProcessed = true;
        break;
      case highTraffic:
        exitStatus();
        setStatus(Status.defaultMode);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;
    
    StatusDefaultMode aStatusDefaultMode = statusDefaultMode;
    switch (aStatusDefaultMode)
    {
      case northAndSouthGreen:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.northAndSouthYellow);
        wasEventProcessed = true;
        break;
      case northAndSouthRed:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.westAndEastYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;
    
    StatusDefaultMode aStatusDefaultMode = statusDefaultMode;
    StatusModerateTraffic aStatusModerateTraffic = statusModerateTraffic;
    switch (aStatusDefaultMode)
    {
      case northAndSouthYellow:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.northAndSouthRed);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        exitStatusDefaultMode();
        setStatusDefaultMode(StatusDefaultMode.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    switch (aStatusModerateTraffic)
    {
      case westAndEastYellowModerate:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.northGreenandArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean northAndSouthGreenWithoutArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    switch (aStatusLowTraffic)
    {
      case northAndSouthArrow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.northAndSouthGreenWithoutArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean northAndSouthYellowWithoutArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    switch (aStatusLowTraffic)
    {
      case northAndSouthGreenWithoutArrow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.northAndSouthYellowWithoutArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean northAndSouthRedWithoutArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    switch (aStatusLowTraffic)
    {
      case northAndSouthYellowWithoutArrow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.northAndSouthRedWithoutArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean westAndEastYellowWithoutArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    switch (aStatusLowTraffic)
    {
      case northAndSouthRedWithoutArrow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.westAndEastYellowWithoutArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean northAndSouthArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusLowTraffic aStatusLowTraffic = statusLowTraffic;
    switch (aStatusLowTraffic)
    {
      case westAndEastYellowWithoutArrow:
        exitStatusLowTraffic();
        setStatusLowTraffic(StatusLowTraffic.northAndSouthArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerGreenAndArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusModerateTraffic aStatusModerateTraffic = statusModerateTraffic;
    switch (aStatusModerateTraffic)
    {
      case northGreenandArrow:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.northYellowModerate);
        wasEventProcessed = true;
        break;
      case southGreenandArrow:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.southYellowModerate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerNorthYellow()
  {
    boolean wasEventProcessed = false;
    
    StatusModerateTraffic aStatusModerateTraffic = statusModerateTraffic;
    switch (aStatusModerateTraffic)
    {
      case northYellowModerate:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.southGreenandArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerSouthYellow()
  {
    boolean wasEventProcessed = false;
    
    StatusModerateTraffic aStatusModerateTraffic = statusModerateTraffic;
    switch (aStatusModerateTraffic)
    {
      case southYellowModerate:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.northAndSouthRedModerate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerNorthAndSouthRedModerate()
  {
    boolean wasEventProcessed = false;
    
    StatusModerateTraffic aStatusModerateTraffic = statusModerateTraffic;
    switch (aStatusModerateTraffic)
    {
      case northAndSouthRedModerate:
        exitStatusModerateTraffic();
        setStatusModerateTraffic(StatusModerateTraffic.westAndEastYellowModerate);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean northYellow()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case northGreenWithArrow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.northYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean northRedAndSouthGreenAndArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case northYellow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.northRedAndSouthGreenAndArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean southYellow()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case northRedAndSouthGreenAndArrow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.southYellow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean southRed()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case southYellow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.southRed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean westGreenWithoutArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case southRed:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.westGreenWithoutArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean westEastYellowWithoutArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case westGreenWithoutArrow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.westEastYellowWithoutArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean northGreenWithArrow()
  {
    boolean wasEventProcessed = false;
    
    StatusHighTraffic aStatusHighTraffic = statusHighTraffic;
    switch (aStatusHighTraffic)
    {
      case westEastYellowWithoutArrow:
        exitStatusHighTraffic();
        setStatusHighTraffic(StatusHighTraffic.northGreenWithArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void exitStatus()
  {
    switch(status)
    {
      case defaultMode:
        exitStatusDefaultMode();
        break;
      case lowTraffic:
        exitStatusLowTraffic();
        break;
      case moderateTraffic:
        exitStatusModerateTraffic();
        break;
      case highTraffic:
        exitStatusHighTraffic();
        break;
    }
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case defaultMode:
        if (statusDefaultMode == StatusDefaultMode.Null) { setStatusDefaultMode(StatusDefaultMode.northAndSouthGreen); }
        break;
      case lowTraffic:
        if (statusLowTraffic == StatusLowTraffic.Null) { setStatusLowTraffic(StatusLowTraffic.northAndSouthArrow); }
        break;
      case moderateTraffic:
        if (statusModerateTraffic == StatusModerateTraffic.Null) { setStatusModerateTraffic(StatusModerateTraffic.northGreenandArrow); }
        break;
      case highTraffic:
        if (statusHighTraffic == StatusHighTraffic.Null) { setStatusHighTraffic(StatusHighTraffic.northGreenWithArrow); }
        break;
    }
  }

  private void exitStatusDefaultMode()
  {
    switch(statusDefaultMode)
    {
      case northAndSouthGreen:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
      case northAndSouthYellow:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
      case northAndSouthRed:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
      case westAndEastYellow:
        setStatusDefaultMode(StatusDefaultMode.Null);
        break;
      default:
        break;
    }
  }

  private void setStatusDefaultMode(StatusDefaultMode aStatusDefaultMode)
  {
    statusDefaultMode = aStatusDefaultMode;
    if (status != Status.defaultMode && aStatusDefaultMode != StatusDefaultMode.Null) { setStatus(Status.defaultMode); }

    // entry actions and do activities
    switch(statusDefaultMode)
    {
      case northAndSouthGreen:
        // line 7 "model.ump"
        trafficLightManager.northGreen();
        // line 8 "model.ump"
        trafficLightManager.southGreen();
        // line 9 "model.ump"
        trafficLightManager.westRed();
        // line 10 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        // line 15 "model.ump"
        trafficLightManager.northYellow();
        // line 16 "model.ump"
        trafficLightManager.southYellow();
        // line 17 "model.ump"
        trafficLightManager.westRed();
        // line 18 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRed:
        // line 22 "model.ump"
        trafficLightManager.northRed();
        // line 23 "model.ump"
        trafficLightManager.southRed();
        // line 24 "model.ump"
        trafficLightManager.westGreen();
        // line 25 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 29 "model.ump"
        trafficLightManager.northRed();
        // line 30 "model.ump"
        trafficLightManager.southRed();
        // line 31 "model.ump"
        trafficLightManager.westYellow();
        // line 32 "model.ump"
        trafficLightManager.eastYellow();
        break;
      default:
        break;
    }
  }

  private void exitStatusLowTraffic()
  {
    switch(statusLowTraffic)
    {
      case northAndSouthArrow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case northAndSouthGreenWithoutArrow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case northAndSouthYellowWithoutArrow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case northAndSouthRedWithoutArrow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      case westAndEastYellowWithoutArrow:
        setStatusLowTraffic(StatusLowTraffic.Null);
        break;
      default:
        break;
    }
  }

  private void setStatusLowTraffic(StatusLowTraffic aStatusLowTraffic)
  {
    statusLowTraffic = aStatusLowTraffic;
    if (status != Status.lowTraffic && aStatusLowTraffic != StatusLowTraffic.Null) { setStatus(Status.lowTraffic); }

    // entry actions and do activities
    switch(statusLowTraffic)
    {
      case northAndSouthArrow:
        // line 41 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 44 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 47 "model.ump"
        trafficLightManager.westRed();
        // line 48 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthGreenWithoutArrow:
        // line 52 "model.ump"
        trafficLightManager.northGreen();
        // line 53 "model.ump"
        trafficLightManager.southGreen();
        // line 54 "model.ump"
        trafficLightManager.westRed();
        // line 55 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellowWithoutArrow:
        // line 59 "model.ump"
        trafficLightManager.northYellow();
        // line 60 "model.ump"
        trafficLightManager.southYellow();
        // line 61 "model.ump"
        trafficLightManager.westRed();
        // line 62 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRedWithoutArrow:
        // line 66 "model.ump"
        trafficLightManager.northRed();
        // line 67 "model.ump"
        trafficLightManager.southRed();
        // line 68 "model.ump"
        trafficLightManager.westGreen();
        // line 69 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellowWithoutArrow:
        // line 73 "model.ump"
        trafficLightManager.northRed();
        // line 74 "model.ump"
        trafficLightManager.southRed();
        // line 75 "model.ump"
        trafficLightManager.westYellow();
        // line 76 "model.ump"
        trafficLightManager.eastYellow();
        break;
      default:
        break;
    }
  }

  private void exitStatusModerateTraffic()
  {
    switch(statusModerateTraffic)
    {
      case northGreenandArrow:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case northYellowModerate:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case southGreenandArrow:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case southYellowModerate:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case northAndSouthRedModerate:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      case westAndEastYellowModerate:
        setStatusModerateTraffic(StatusModerateTraffic.Null);
        break;
      default:
        break;
    }
  }

  private void setStatusModerateTraffic(StatusModerateTraffic aStatusModerateTraffic)
  {
    statusModerateTraffic = aStatusModerateTraffic;
    if (status != Status.moderateTraffic && aStatusModerateTraffic != StatusModerateTraffic.Null) { setStatus(Status.moderateTraffic); }

    // entry actions and do activities
    switch(statusModerateTraffic)
    {
      case northGreenandArrow:
        // line 86 "model.ump"
        trafficLightManager.northArrow();
        // line 87 "model.ump"
        trafficLightManager.northGreen();
        // line 88 "model.ump"
        trafficLightManager.westRed();
        // line 89 "model.ump"
        trafficLightManager.eastRed();
        // line 90 "model.ump"
        trafficLightManager.southRed();
        break;
      case northYellowModerate:
        // line 95 "model.ump"
        trafficLightManager.northYellow();
        // line 96 "model.ump"
        trafficLightManager.westRed();
        // line 97 "model.ump"
        trafficLightManager.eastRed();
        // line 98 "model.ump"
        trafficLightManager.southRed();
        break;
      case southGreenandArrow:
        // line 102 "model.ump"
        trafficLightManager.southArrow();
        // line 103 "model.ump"
        trafficLightManager.southGreen();
        // line 104 "model.ump"
        trafficLightManager.westRed();
        // line 105 "model.ump"
        trafficLightManager.eastRed();
        // line 106 "model.ump"
        trafficLightManager.northRed();
        break;
      case southYellowModerate:
        // line 110 "model.ump"
        trafficLightManager.southYellow();
        // line 111 "model.ump"
        trafficLightManager.westRed();
        // line 112 "model.ump"
        trafficLightManager.eastRed();
        // line 113 "model.ump"
        trafficLightManager.northRed();
        break;
      case northAndSouthRedModerate:
        // line 117 "model.ump"
        trafficLightManager.northRed();
        // line 118 "model.ump"
        trafficLightManager.southRed();
        // line 119 "model.ump"
        trafficLightManager.westGreen();
        // line 120 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellowModerate:
        // line 124 "model.ump"
        trafficLightManager.northRed();
        // line 125 "model.ump"
        trafficLightManager.southRed();
        // line 126 "model.ump"
        trafficLightManager.westYellow();
        // line 127 "model.ump"
        trafficLightManager.eastYellow();
        break;
      default:
        break;
    }
  }

  private void exitStatusHighTraffic()
  {
    switch(statusHighTraffic)
    {
      case northGreenWithArrow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case northYellow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case northRedAndSouthGreenAndArrow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case southYellow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case southRed:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case westGreenWithoutArrow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      case westEastYellowWithoutArrow:
        setStatusHighTraffic(StatusHighTraffic.Null);
        break;
      default:
        break;
    }
  }

  private void setStatusHighTraffic(StatusHighTraffic aStatusHighTraffic)
  {
    statusHighTraffic = aStatusHighTraffic;
    if (status != Status.highTraffic && aStatusHighTraffic != StatusHighTraffic.Null) { setStatus(Status.highTraffic); }

    // entry actions and do activities
    switch(statusHighTraffic)
    {
      case northGreenWithArrow:
        // line 137 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 140 "model.ump"
        trafficLightManager.southRed();
        // line 141 "model.ump"
        trafficLightManager.westRed();
        // line 142 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellow:
        // line 146 "model.ump"
        trafficLightManager.northYellow();
        // line 147 "model.ump"
        trafficLightManager.southRed();
        // line 148 "model.ump"
        trafficLightManager.westRed();
        // line 149 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northRedAndSouthGreenAndArrow:
        // line 153 "model.ump"
        trafficLightManager.northRed();
        // line 154 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 157 "model.ump"
        trafficLightManager.westRed();
        // line 158 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellow:
        // line 162 "model.ump"
        trafficLightManager.northRed();
        // line 163 "model.ump"
        trafficLightManager.southYellow();
        // line 164 "model.ump"
        trafficLightManager.westRed();
        // line 165 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southRed:
        // line 169 "model.ump"
        trafficLightManager.northRed();
        // line 170 "model.ump"
        trafficLightManager.southRed();
        // line 171 "model.ump"
        trafficLightManager.westGreenAndArrow();
        // line 174 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westGreenWithoutArrow:
        // line 178 "model.ump"
        trafficLightManager.northRed();
        // line 179 "model.ump"
        trafficLightManager.southRed();
        // line 180 "model.ump"
        trafficLightManager.westGreen();
        // line 181 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westEastYellowWithoutArrow:
        // line 185 "model.ump"
        trafficLightManager.northRed();
        // line 186 "model.ump"
        trafficLightManager.southRed();
        // line 187 "model.ump"
        trafficLightManager.westYellow();
        // line 188 "model.ump"
        trafficLightManager.eastYellow();
        break;
      default:
        break;
    }
  }

  public void delete()
  {}

}
