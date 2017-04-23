package com.netcracker.kutz.enumeration;

import com.netcracker.kutz.command.user.BlockAccountCommand;
import com.netcracker.kutz.command.LoginCommand;
import com.netcracker.kutz.command.user.TransferCommand;
import com.netcracker.kutz.command.admin.UnblockAccountCommand;
import com.netcracker.kutz.implement.ActionCommand;

/**
 * Created by Егор on 21.04.17.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    TRANSFER {
        {
            this.command = new TransferCommand();
        }
    },
    BLOCK {
        {
            this.command = new BlockAccountCommand();
        }
    },
    UNBLOCK {
        {
            this.command = new UnblockAccountCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
