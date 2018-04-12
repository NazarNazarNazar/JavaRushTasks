package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    public void run() {
        getSocketThread().run();
    }

    public ClientGuiModel getModel() {
        return model;
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    public class GuiSocketThread extends SocketThread {
        //должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления
//        @Override
//        protected void processIncomingMessage(String message) {
//            model.setNewMessage(message);
//            view.refreshMessages();
//        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            model.setNewMessage(message);
            view.refreshMessages();
        }

        //должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения
//        @Override
//        protected void informAboutAddingNewUser(String userName) {
//            model.addUser(userName);
//            view.refreshUsers();
//        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            super.informAboutAddingNewUser(userName);
            model.addUser(userName);
            view.refreshUsers();
        }

        //должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения
//        @Override
//        protected void informAboutDeletingNewUser(String userName) {
//            model.deleteUser(userName);
//            view.refreshUsers();
//        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            super.informAboutDeletingNewUser(userName);
            model.deleteUser(userName);
            view.refreshUsers();
        }

        //должен вызывать аналогичный метод у представления
//        @Override
//        protected void notifyConnectionStatusChanged(boolean clientConnected) {
//            view.notifyConnectionStatusChanged(clientConnected);
//        }
        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            super.notifyConnectionStatusChanged(clientConnected);
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
