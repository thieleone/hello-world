package uebung6;

public interface ReadWriteLock {
	 public void acquireReadLock();
	 public void acquireWriteLock();
	 public void releaseReadLock();
	 public void releaseWriteLock();
	}
