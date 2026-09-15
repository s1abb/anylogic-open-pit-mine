@Override
public void onRunStarted() {
    for (a_Node node : main.p_Network.p_Nodes) {
        if (node != null && node.id != null && node.id.equals(this.nodeId)) {
            this.jumpTo(node.x, node.y, node.z);
            break;
        }
    }
}