@Override
public void onRunStarted() {
    if (nodesRef == null) return;
    for (a_Node node : nodesRef) {
        if (node != null && node.id != null && node.id.equals(this.nodeId)) {
            this.jumpTo(node.x, node.y, node.z);
            break;
        }
    }
}