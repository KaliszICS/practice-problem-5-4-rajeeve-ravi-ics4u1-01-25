/**
 * The interface Player.
 */
interface Player {
    /**
     * Start.
     */
    void start();

    /**
     * Stop.
     */
    void stop();

    /**
     * Volume up.
     */
    void volumeUp();

    /**
     * Volume down.
     */
    void volumeDown();

    /**
     * Gets volume.
     *
     * @return the volume
     */
    int getVolume();
}

/**
 * The type Music player.
 */
class MusicPlayer implements Player {
    private boolean onOff;
    private String[] musicList;
    private String currentSong;
    private int volume;
    private int currentIndex = 0;

    /**
     * Instantiates a new Music player.
     *
     * @param musicList the music list
     */
    public MusicPlayer(String[] musicList) {
        this.musicList = musicList;
        this.volume = 0;
        this.onOff = false;
        this.currentSong = "";
    }

    @Override
    public void start() {
        if (!onOff) {
            onOff = true;
            if (musicList.length > 0) {
                currentIndex = 0;
                currentSong = musicList[currentIndex];
            }
        }
    }

    @Override
    public void stop() {
        if (onOff) {
            onOff = false;
            currentSong = "";
        }
    }

    /**
     * Gets on off.
     *
     * @return the on off
     */
    public boolean getOnOff() { return onOff; }

    @Override
    public void volumeUp() { volume++; }

    @Override
    public void volumeDown() { volume--; }

    @Override
    public int getVolume() { return volume; }

    /**
     * Next.
     */
    public void next() {
        if (musicList.length > 0) {
            currentIndex = (currentIndex + 1) % musicList.length;
            currentSong = musicList[currentIndex];
        }
    }

    /**
     * Previous.
     */
    public void previous() {
        if (musicList.length > 0) {
            currentIndex = (currentIndex - 1 + musicList.length) % musicList.length;
            currentSong = musicList[currentIndex];
        }
    }

    /**
     * Gets current song.
     *
     * @return the current song
     */
    public String getCurrentSong() { return currentSong; }
}

/**
 * The type Radio player.
 */
class RadioPlayer implements Player {
    private boolean onOff;
    private double[] stationList;
    private int volume;
    private double station;
    private int currentIndex = 0;

    /**
     * Instantiates a new Radio player.
     *
     * @param stationList the station list
     */
    public RadioPlayer(double[] stationList) {
        this.stationList = stationList;
        this.volume = 0;
        this.onOff = false;
        this.station = 0;
    }

    @Override
    public void start() {
        if (!onOff) {
            onOff = true;
            if (stationList.length > 0) {
                currentIndex = 0;
                station = stationList[currentIndex];
            }
        }
    }

    @Override
    public void stop() {
        if (onOff) {
            onOff = false;
            station = 0;
        }
    }

    /**
     * Gets on off.
     *
     * @return the on off
     */
    public boolean getOnOff() { return onOff; }

    @Override
    public void volumeUp() { volume += 2; }

    @Override
    public void volumeDown() { volume -= 2; }

    @Override
    public int getVolume() { return volume; }

    /**
     * Next.
     */
    public void next() {
        if (stationList.length > 0) {
            currentIndex = (currentIndex + 1) % stationList.length;
            station = stationList[currentIndex];
        }
    }

    /**
     * Previous.
     */
    public void previous() {
        if (stationList.length > 0) {
            currentIndex = (currentIndex - 1 + stationList.length) % stationList.length;
            station = stationList[currentIndex];
        }
    }

    /**
     * Gets station.
     *
     * @return the station
     */
    public double getStation() { return station; }
}

/**
 * The type Video player.
 */
class VideoPlayer implements Player {
    private boolean onOff;
    private String video;
    private int currentTime;
    private int volume;

    /**
     * Instantiates a new Video player.
     *
     * @param video the video
     */
    public VideoPlayer(String video) {
        this.video = video;
        this.volume = 0;
        this.onOff = false;
        this.currentTime = 0;
    }

    @Override
    public void start() {
        if (!onOff) {
            onOff = true;
        }
    }

    @Override
    public void stop() {
        if (onOff) {
            onOff = false;
        }
    }

    /**
     * Gets on off.
     *
     * @return the on off
     */
    public boolean getOnOff() { return onOff; }

    @Override
    public void volumeUp() { volume += 5; }

    @Override
    public void volumeDown() { volume -= 5; }

    @Override
    public int getVolume() { return volume; }

    /**
     * Fast forward.
     */
    public void fastForward() { currentTime += 5; }

    /**
     * Rewind.
     */
    public void rewind() { currentTime -= 5; }

    /**
     * Gets current time.
     *
     * @return the current time
     */
    public int getCurrentTime() { return currentTime; }

    /**
     * Gets video.
     *
     * @return the video
     */
    public String getVideo() { return video; }

    /**
     * Sets video.
     *
     * @param video the video
     */
    public void setVideo(String video) { this.video = video; }
}
