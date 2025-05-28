package labo1.Task3

import labo1.Task1.Display

class MonitorComparer() {
    // Method to compare each display object sequentially
    public fun compareMonitors(monitorList: List<Display>) {
        for (i in monitorList.indices) {
            for (j in i + 1 until monitorList.size) {
                val firstMonitor = monitorList[i]
                val secondMonitor = monitorList[j]
                firstMonitor.compareSize(secondMonitor)
                firstMonitor.compareSharpness(secondMonitor)
                firstMonitor.compareWithMonitor(secondMonitor)
            }
        }
    }
}